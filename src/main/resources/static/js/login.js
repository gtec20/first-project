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