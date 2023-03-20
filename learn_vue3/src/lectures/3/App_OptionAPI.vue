<!-- vbase를 하면 템플릿들이 나온다. !로 했을때 html템플릿이 나오는거와 같은 것이다. -->
<template>
	<div>
		<button v-on:click="increment">Counter: {{ counter }}</button>
	</div>
</template>

<script>
export default {
	data() {
		return {
			counter: 0,
		};
	},
	methods: {
		increment() {
			this.counter++;
		},
	},
	mounted() {
		console.log('컴포넌트가 마운트 되었습니다.');
	},
};
</script>

<style lang="scss" scoped></style>
