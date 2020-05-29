function add() {
    if ($("#name").val() == undefined || $("#name").val() == '' ||
        $("#content").val() == undefined || $("#content").val() == '' ||
        $("#auth").val() == undefined || $("#auth").val() == '' ||
        $("#number").val() == undefined || $("#number").val() == '') {
        alert("含有空值！")
    } else {
        $.ajax({
            type: "POST",
            dataType: "text",
            url: "http://localhost:8080/addBook",
            data: $('#addBook').serialize(),
            success: function(result) {
                alert(result)
            },
            error: function(error) {
                console.log(error)
                alert("发生异常")
            }
        })
    }

}

function find() {
    if ($("#findBookName").val() == undefined || $("#findBookName").val() == '') {
        alert("请输入正确的图书名！")
    } else {
        $.ajax({
            type: "POST",
            dataType: "text",
            url: "http://localhost:8080/findOne",
            data: $("#findBookName").serialize(),
            success: function(result) {
                alert(result)

            },
            error: function(error) {
                console.log(error)
                alert("发生异常")
            }
        })
    }
}

function del() {
    if ($("#delBookName").val() == undefined || $("#delBookName").val() == '') {
        alert("输入正确的图书名！")
    } else {
        $.ajax({
            type: "POST",
            dataType: "text",
            url: "http://localhost:8080/delOne",
            data: $('#delBookName').serialize(),
            success: function(result) {
                alert(result)
            },
            error: function(error) {
                console.log(error)
                alert("发生异常")
            }
        })
    }
}

function findAll() {
    window.location.href = "http://localhost:8080/findAllBook"
}

function b() {
    console.log($("#findBookName").serialize())
}