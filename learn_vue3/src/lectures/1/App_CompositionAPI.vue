<!-- vbase-3를 하면 템플릿들이 나온다. 이거는 setup함수까지 같이 템플릿이 만들어져 준다.  -->
<template>
	<div>
		<button v-on:click="increment">Counter: {{ counter }}</button>
	</div>
</template>

<script>
import { onMounted, ref } from 'vue';

export default {
	setup() {
		const counter = ref(0);
		const increment = () => counter.value++;

		onMounted(() => {
			console.log('컴포넌트가 마운트 되었습니다.');
		});

		return {
			counter,
			increment,
		};
	},
};
</script>

<style lang="scss" scoped></style>
