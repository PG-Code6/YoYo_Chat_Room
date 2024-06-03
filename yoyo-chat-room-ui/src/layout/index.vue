<template>
	<el-container>
		<!--侧边栏-->
		<el-aside width="80px" class="asideOne_Style">
			<Sidebar/>
		</el-aside>
			<!--内容-->
    <el-main>
      <router-view/>
    </el-main><!--main-->
	</el-container>
</template>

<script>
import Sidebar from "@/layout/components/sidebar";

export default {
	name: "index",
	components: {
		Sidebar
	},

  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    }
  }

}
</script>

<!--样式-->
<style scoped>
.asideOne_Style{
  /*background-color: #000;*/
  height: 100vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: rgb(134,86,142);
}
.asideTwo_Style{
  /*background-color: #363535;*/
  background-color: rgb(134,86,142);
  height: 900px;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.foot_Style{
  display: flex;
  border-radius: 100px !important;
  overflow: hidden;
  border: 1px solid red;

}

.set_image{
  padding-top: 5px;
  width: 40px;
  height: 40px;
}
.four_style{
  padding-top: 600px;
  }


.el-header {
  border-bottom: 1px #000 solid;
  /*background-color: #565657;*/
  background-color: rgb(134,86,142);
  color: #333;
  text-align: center;
  line-height: 60px;
  border-bottom: 2px solid #a9a9a9;
}

.el-main {
  align-self: auto;
  background-color: rgb(134,86,142);
  /*background-color: #565657;*/
  color: #333;
  text-align: center;
  padding: 0 !important;
  /*line-height: 300px;*/
}
</style>
