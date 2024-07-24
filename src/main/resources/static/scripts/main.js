document.addEventListener('DOMContentLoaded', () => {
    const token = localStorage.getItem('token');
    if (!token) {
        window.location.href = 'login.html';
    }

    const elem = document.querySelector('#movie-cards-container');
    const infScroll = new InfiniteScroll(elem, {
        path: function() {
            return `/api/movies?page=${this.pageIndex + 1}`;
        },
        append: '.movie-card',
        history: false,
        responseType: 'text',
        headers: {
            'Authorization': `Bearer ${token}`
        }
    });

    infScroll.on('load', (response) => {
        const items = document.createElement('div');
        items.innerHTML = response;

        const cards = items.querySelectorAll('.movie-card');
        infScroll.appendItems(cards);
    });

    document.getElementById('search-input').addEventListener('input', (event) => {
        const query = event.target.value.toLowerCase();
        const cards = document.querySelectorAll('.movie-card');
        cards.forEach(card => {
            const title = card.querySelector('.movie-title').textContent.toLowerCase();
            if (title.includes(query)) {
                card.style.display = '';
            } else {
                card.style.display = 'none';
            }
        });
    });
});
