<template>
  <div style="height: 100vh; display: flex; align-items: center; justify-content: center; background-color:#9acaf6;">
    <!--  登录部分-->
    <div style="display: flex; background-color:#fff;width: 55%; height: 50%; overflow: hidden; border-radius: 5px; margin-top: -10%">
      <div style="flex: 1;">
        <img src="../assets/login.png" style="width: 100%;">
      </div>
      <!--    登录右侧表单-->
      <div style="flex: 1; display: flex; align-items: center; justify-content: center;">
        <el-form :model="user" style="width: 80%;">
          <div style="font-size: 30px; font-weight: bold; text-align: left; margin-bottom: 20px;">注册界面</div>
          <el-form-item prop="username">
            <el-input prefix-icon="User" size="large" placeholder="请输入账号" v-model="user.username"></el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input prefix-icon="Lock" size="large" show-password placeholder="请输入密码" v-model="user.password"></el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input prefix-icon="Lock" size="large" show-password placeholder="请再次输入密码" v-model="password"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" style="width: 100%;" @click="register">注 册</el-button>
          </el-form-item>
          <div style="color: #1890ff; font-size: smaller; cursor: pointer;" @click="return_login">
            返回
          </div>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";
import router from "@/router";

export default {
  name: "RegisterView",
  data(){
    return{
      user:{
        username:'',
        password:''
      },
      password:''  //验证密码
    }
  },
  methods:{
    register(){
      if(this.user.password === this.password){
        request.post('/register',this.user).then(res => {
          this.$message.success("注册成功");
          this.$router.push('/login');
          console.log(res)
        })
      }else{
        this.$message.error("两次密码不一致");
      }
    },
    return_login(){
      this.$router.push('/login');
    }
  }
}
</script>

<style scoped>

</style>
