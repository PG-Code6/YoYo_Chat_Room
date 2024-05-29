<template>
  <div class="about">
		<el-container>
			<el-aside width="200px" style="background-color:red;">Aside</el-aside>
			<el-main style="background-color:green;">{{msg}}</el-main>
		</el-container>

		<el-row>
			<el-button>默认按钮</el-button>
			<el-button type="primary">主要按钮</el-button>
			<el-button type="success">成功按钮</el-button>
			<el-button type="info">信息按钮</el-button>
			<el-button type="warning">警告按钮</el-button>
			<el-button type="danger">危险按钮</el-button>
		</el-row>

		<div>
			<h1 class="lsq">HHHHHH</h1>
		</div>
  </div>
</template>
<!--js区域-->
<script>
export default {
  name: 'AboutView',
	data() {
		return {
			msg: 'Welcome to Your Vue.js App'
		}
	},
	//初始化函数
	mounted() {

	},
	//函数定义
	methods:{
		getData(){

		}
	}
}
</script>

<!--css样式-->
<style scoped>
h1{
	color: green;
}
</style>
