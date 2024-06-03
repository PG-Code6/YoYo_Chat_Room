<template>

	<div class="aside_root">
    <img src="../../assets/狗.png" class="set_image">
    <el-row>
      <el-col :span="12">

        <el-menu
            default-active="/community"
            class="el-menu-vertical-demo"
            background-color="rgb(134,86,142)"
            text-color="#fff"
            active-text-color="#ffd04b" router>

          <el-menu-item index="/community">
            <i class="el-icon-s-home"></i>
            <span slot="title"></span>
          </el-menu-item>
          <el-menu-item index="/friendchat">
            <i class="el-icon-basketball"></i>
            <span slot="title"></span>
          </el-menu-item>
          <el-menu-item index="/songoodfriend">
            <i class="el-icon-user-solid"></i>
            <span slot="title"></span>
          </el-menu-item>

          <el-menu-item class="four_style">
            <i class="el-icon-s-tools"></i>
            <span slot="title"></span>
          </el-menu-item>

        </el-menu>
      </el-col>
    </el-row>

  </div>
</template>

<script>

export default {
	name: "sidebar",
	data() {
		return {
		}
	},
	mounted() {

	},
	methods: {
	}
}
</script>

<style scoped>

.aside_root{
  /*background-color: #000;*/
  background-color: rgb(134,86,142);
  height: 100vh;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.set_image{
  padding-top: 1vh;
  width: 3vw;
  height: 4vh;
}
.four_style{
  padding-top: 70vh;
  /*border: 2px red solid;*/
}

.el-menu-item:hover{
  background-color:  rgb(134,86,142) !important;
}

</style>
