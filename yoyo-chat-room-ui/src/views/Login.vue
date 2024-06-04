<template>
  <div class="bigbox">
    <div>
      <div class="container">
        <div class="form-box" :class="{ 'slide-right': isLogin }">
          <!-- 注册 -->
          <div class="register-box" v-if="isLogin" >
            <h1>register</h1>
              <input type="text"  v-model="user.userName" placeholder="用户名">
              <input type="password" v-model="user.userPassword" placeholder="密码" >
              <input type="password" v-model="user.userPassword2" placeholder="确认密码" >
              <button @click="register">注册</button>
          </div>
          <!-- 登录 -->
          <div class="login-box"  v-if="!isLogin">
            <h1>login</h1>
            <input type="text" placeholder="用户名" v-model="user.userName">
            <input type="password" placeholder="密码" v-model="user.userPassword">
            <button id="login" @click="login" >登录</button>
          </div>
        </div>


        <div class="con-box left">
          <h2>欢迎来到<span>yoyo聊天室</span></h2>
          <p>快来开启你的专属<span>聊天旅程</span>吧</p>
          <img src="../assets/cat/1.png" alt="">
          <p>已有账号</p>
          <button id="go_login" @click="toggleForm">去登录</button>
        </div>


        <div class="con-box right">
          <h2>欢迎来到<span>yoyo聊天室</span></h2>
          <p>快来看看你的可爱<span>伙伴</span>吧</p>
          <img src="../assets/cat/2.png" alt="">
          <p>没有账号？</p>
          <button id="register" @click="toggleForm">去注册</button>
        </div>
      </div>
    </div>
  </div>


</template>




<script>
import router from "@/router";
import axios from "axios";
import request from "@/utils/request";



export default {
  computed: {
    rules() {
      return rules
    }
  },
  data() {
    return {
      isLogin: true, // 控制显示登录还是注册表单的标志
      user: {
        userName: '',
        userPassword: '',
        userPassword2: '',
        userId:''
      },
    };
  },
  methods: {

    toggleForm() {
      this.isLogin = !this.isLogin;
    },
   login(){
      if(this.user.userName==='')  this.$message.success('请输入用户名');
      else if(this.user.userPassword==='') this.$message.success('请输入密码');
      else request.post('/login',this.user).then((res)=>{
        if(res.data.code==="200"){
          this.$message.success('登录成功');

          router.push('/community');
        }else{
          this.$message.success('登录失败:'+res.data.msg);

        }
      })

    },
    register(){

      if(this.user.userName==='') this.$message.success("用户名不能为空");
      else if(this.user.userPassword==='') this.$message.success("密码不能为空");
      else if(this.user.userPassword2==='') this.$message.success("确认密码不能为空");
      else if(this.user.userPassword!==this.user.userPassword2)this.$message.success("密码不一致");
      else if(this.user.userPassword===this.user.userPassword2) {
        request.get('/user/selectUserByName', {
          params: {
            userName: this.user.userName
          }
        }).then((res)=>{
          if(res.data.data!==null){

            this.$message.success("用户名已存在");
          }
          else   request.put('/user/insertUser',this.user).then((res)=>{
            if(res.data.code==="200"){
              this.$message.success("注册成功，快去登录吧");
              this.isLogin=!this.isLogin;
            }else{
              this.$message.success("注册失败");
            }
          })
        })

      }

    },


  },
};
</script>

<style scoped>

.slide-right {
  transform: translateX(80%);
  transition: transform 0.5s ease-in-out;
}

*{
  /* 初始化 */
  margin: 0;
  padding: 0;
}
.bigbox{
  /* 100%窗口高度 */
  height: 100vh;
  /* 弹性布局 水平+垂直居中 */
  display: flex;
  justify-content: center;
  align-items: center;
  /* 渐变背景 */
  background: linear-gradient(200deg,#f3e7e9,#e3eeff);
}
.container{
  background-color: #fff;
  width: 650px;
  height: 415px;
  border-radius: 5px;
  /* 阴影 */
  box-shadow: 5px 5px 5px rgba(0,0,0,0.1);
  /* 相对定位 */
  position: relative;
}
.form-box{
  /* 绝对定位 */
  position: absolute;
  top: -10%;
  left: 5%;
  background-color: #d3b7d8;
  width: 320px;
  height: 500px;
  border-radius: 5px;
  box-shadow: 2px 0 10px rgba(0,0,0,0.1);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 2;
  /* 动画过渡 加速后减速 */
  transition: 0.5s ease-in-out;
}
.register-box,.login-box{
  /* 弹性布局 垂直排列 */
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
}

h1{
  text-align: center;
  margin-bottom: 25px;
  /* 大写 */
  text-transform: uppercase;
  color: #fff;
  /* 字间距 */
  letter-spacing: 5px;
}
input{
  background-color: transparent;
  width: 70%;
  color: #fff;
  border: none;
  /* 下边框样式 */
  border-bottom: 1px solid rgba(255,255,255,0.4);
  padding: 10px 0;
  text-indent: 10px;
  margin: 8px 0;
  font-size: 14px;
  letter-spacing: 2px;
}
input::placeholder{
  color: #fff;
}
input:focus{
  color: #a262ad;
  outline: none;
  border-bottom: 1px solid #a262ad80;
  transition: 0.5s;
}
input:focus::placeholder{
  opacity: 0;
}
.form-box button{
  width: 70%;
  margin-top: 35px;
  background-color: #f6f6f6;
  outline: none;
  border-radius: 8px;
  padding: 13px;
  color: #a262ad;
  letter-spacing: 2px;
  border: none;
  cursor: pointer;
}
.form-box button:hover{
  background-color: #a262ad;
  color: #f6f6f6;
  transition: background-color 0.5s ease;
}
.con-box{
  width: 50%;
  /* 弹性布局 垂直排列 居中 */
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  /* 绝对定位 居中 */
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
}
.con-box.left{
  left: -2%;
}
.con-box.right{
  right: -2%;
}
.con-box h2{
  color: #8e9aaf;
  font-size: 25px;
  font-weight: bold;
  letter-spacing: 3px;
  text-align: center;
  margin-bottom: 4px;
}
.con-box p{
  font-size: 12px;
  letter-spacing: 2px;
  color: #8e9aaf;
  text-align: center;
}
.con-box span{
  color: #d3b7d8;
}
.con-box img{
  width: 150px;
  height: 150px;
  opacity: 0.9;
  margin: 40px 0;
}
.con-box button{
  margin-top: 3%;
  background-color: #fff;
  color: #a262ad;
  border: 1px solid #d3b7d8;
  padding: 6px 10px;
  border-radius: 5px;
  letter-spacing: 1px;
  outline: none;
  cursor: pointer;
}
.con-box button:hover{
  background-color: #d3b7d8;
  color: #fff;
}
</style>