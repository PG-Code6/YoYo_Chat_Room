<template>
	<el-container>
		<!--侧边栏-->
		<el-aside>
			<Sidebar/>
		</el-aside>
			<!--内容-->
			<el-main>
				<router-view/>
			</el-main>
	</el-container>
</template>

<script>
import Sidebar from "@/layout/components/sidebar";

export default {
	name: "index",
	components: {
		Sidebar
	}
}
</script>

<style scoped>

</style>
