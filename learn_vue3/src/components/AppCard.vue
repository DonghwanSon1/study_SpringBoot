<template>
	<div class="card">
		<div class="card-body">
			<h5 class="card-title red">Card title</h5>
			<p class="card-text">
				Some quick example text to build on the card title and make up the bulk
				of the card's content.
			</p>
			<a href="#" class="btn btn-primary">Go somewhere</a>
		</div>
	</div>
</template>

<script>
import { ref } from 'vue';

export default {
	setup() {
		// const style = useCssModule();
		// console.log('style: ', style);
		console.log('AppCard setup()');

		const color = ref('red');
		color.value = 'blue';
		return {
			color,
		};
	},
};
</script>

<!-- <style module>
.red {
	color: red !important;
}
</style> -->

<style>
.red {
	color: v-bind(color) !important;
}
</style>

<!-- <style lang="scss" scoped>
.red {
	color: red !important;
}
</style>  
-> scoped는 현재 이 파일에서만 style이 변경된다.-->

<!-- <style module>
.red {
	color: red !important;
}
</style> 
-> 모듈로 사용할 시 $style.클래스명 으로 모듈화 할 수 있다.-->

<!-- <style module="classes">
.red {
	color: red !important;
}
</style> -->
