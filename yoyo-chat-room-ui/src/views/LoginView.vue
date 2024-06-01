<template>
	<div style="height: 100vh; display: flex; align-items: center; justify-content: center; background-color:#9acaf6;">
		<!--  登录部分-->
		<div style="display: flex; background-color:#fff;width: 55%; height: 50%; overflow: hidden; border-radius: 5px; margin-top: -10%">
			<div style="flex: 1;">
				<img src="../assets/login.png" style="width: 100%;">
			</div>
			<!--    登录右侧表单-->
			<div style="flex: 1; display: flex; align-items: center; justify-content: center;">
				<el-form :model="user" style="width: 80%;" :rules="rules" ref="loginRef">
					<div style="font-size: 20px; font-weight: bold; text-align: center; margin-bottom: 20px;">欢迎来到零度代码</div>
					<el-form-item prop="username">
						<el-input size="large" placeholder="请输入账号" v-model="user.username">
							<i slot="prefix" class="el-icon-user" style="font-size: 20px"></i>
						</el-input>
					</el-form-item>
					<el-form-item prop="password">
						<el-input size="large" show-password placeholder="请输入密码" v-model="user.password">
							<i slot="prefix" class="el-icon-lock" style="font-size: 20px"></i>
						</el-input>
					</el-form-item>
					<el-form-item>
						<el-button type="primary" style="width: 100%;" @click="login">登 录</el-button>
					</el-form-item>
					<div style="display: flex; justify-content: space-between">
						<div>还没有账号？请 <span style="color:#1890ff; cursor: pointer" @click="return_register">注册</span></div>
						<div style="cursor: pointer;color:#1890ff;">忘记密码</div>
					</div>
				</el-form>
			</div>
		</div>
	</div>
</template>

<script>

import request from "@/utils/request"
import router from '@/router'

export default {
	name: "Login",
	data(){
		return{
			user:{
				username:'',
				password:'',
			},
			rules:{
				username:[
					{ required: true, message:'请输入账号',trigger:'blur'}
				],
				password:[
					{ required: true, message:'请输入密码',trigger:'blur'}
				]
			}
		}
	},
	methods:{
		login(){
			router.push('/home')
		},
		return_register(){
			router.push('/register')
		}
	}
}
</script>

<style scoped>

</style>
