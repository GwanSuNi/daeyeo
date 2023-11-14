document.getElementById('phone').addEventListener('input', function (e) {
    let value = e.target.value.replace(/\D/g, '');
    let formattedValue = '';

    if (value.startsWith('02')) { // 지역번호가 '02'로 시작하는 경우
        if (value.length >= 1) {
            formattedValue = value.substring(0, 2); // 앞에 2자리 (지역번호)
        }
        if (value.length >= 3) {
            formattedValue = formattedValue + '-' + value.substring(2, 6); // 가운데 4자리
        }
        if (value.length >= 7) {
            formattedValue = formattedValue + '-' + value.substring(6, 10); // 뒤에 4자리
        }
    } else { // 그 외의 경우
        if (value.length >= 1) {
            formattedValue = value.substring(0, 3); // 앞에 3자리
        }
        if (value.length >= 4) {
            formattedValue = formattedValue + '-' + value.substring(3, 7); // 가운데 4자리
        }
        if (value.length >= 8) {
            formattedValue = formattedValue + '-' + value.substring(7, 11); // 뒤에 4자리
        }
    }

    e.target.value = formattedValue.substring(0, 14);
});