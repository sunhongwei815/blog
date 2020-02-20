//  注册
function reg() {
    var name = document.getElementById("name").value;   //获取到前端输入的用户名
    var password = document.getElementById("password").value;	//获取到前端输入的密码
    var obj = {
        username:name,
        password:password,
    }

    $.ajax({
        "url": "loacalhost:8080/reg",    //reg是注册接口
        type:'POST',
        dataType:'json',
        contentType:'application/json',
        data:JSON.stringify(obj),
        success: function (result) {
            if (result == 1) {
                alert("注册成功");
            }else if(result == 2){
                alert("密码不能为空");
            }else if(result == 3){
                alert("账号不能为空");
            } else {
                alert("用户名已被注册");
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log('XMLHttpRequest:');
            console.log(XMLHttpRequest);
            alert('网络异常！尝试刷新网页解决问题')
        }


    });
}


//登录
function login(){
    var name = document.getElementById("name").value;
    var password = document.getElementById("password").value;
    $.ajax({
        url: "localhost:8080/loginIn",        //login是登录接口
        type: "POST",
        dataType: "text",
        data:{
            name:name,
            password:password
        },
        success: function(result){
            alert(result);
            if (result=="success") {
                alert("登录成功");
            }else{
                layer.alert("账号或密码不正确");
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log('XMLHttpRequest:');
            console.log(XMLHttpRequest);
            layer.alert('网络异常！尝试刷新网页解决问题')
        }
    });
}

