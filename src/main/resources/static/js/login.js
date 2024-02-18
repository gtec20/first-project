function IsIdPwCheck(id, pw) {
    if(id.length < 1) {
        $('#id').focus();
        alert("아이디를 입력해 주세요");
        return false;
    }
    if(pw.length < 1) {
        $('#pw').focus();
        alert("비밀번호를 입력해 주세요");
        return false;
    }
    return true;
}

$('#login').on('click', function () {
    let id = $('#id').val();
    let pw = $('#pw').val();

    if(!IsIdPwCheck(id, pw)) {
        return;
    }

    let url = '/api/login';
    let data = { id: id, pw: pw };

    $.ajax({
        url: url,
        type: 'GET',
        data: data,
        success: function (res) {
            alert(res);
        },
        error: function (err) {
            alert(err);
        }
    });
});