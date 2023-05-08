function iHeight(ifrm) {
    ifrm.height = 100;
    ifrm.height = ifrm.contentWindow.document.body.scrollHeight;
}

function changeType(type) {
    if (type === 'board') {
        document.getElementById('board_type').className = 'active';
        document.getElementById('list_type').classList.remove('active');
    } else {
        document.getElementById('list_type').className = 'active';
        document.getElementById('board_type').classList.remove('active');
    }

    let ifrm = document.getElementById('rental_list');
    ifrm.src = type;
    iHeight(ifrm);
}