<template>
	<div>
		<h2>반응형 메시지</h2>
		<p>{{ reactivMessage }}</p>
		<button v-on:click="addReactiveMessage">Add Message</button>
		<h2>일반 메시지</h2>
		<p>{{ normalMessage }}</p>
		<button v-on:click="addNormalMessage">Add Message</button>
	</div>
</template>

<script>
import { isRef, onBeforeMount, onMounted, ref } from 'vue';

export default {
	setup() {
		console.log('setup()');
		const reactivMessage = ref('Hello Reactive Message ~~~');
		const addReactiveMessage = () => {
			reactivMessage.value += '!';
		};
		console.log('isRef(reactivMessage): ', isRef(reactivMessage));

		let normalMessage = 'Hello Nomal Message ~~~';
		const addNormalMessage = () => {
			normalMessage += '!';
		};
		console.log('isRef(normalMessage): ', isRef(normalMessage));

		onMounted(() => {
			console.log('onMounted');
		});
		onBeforeMount(() => {
			console.log('onBeforeMount');
		});

		return {
			reactivMessage,
			addReactiveMessage,
			normalMessage,
			addNormalMessage,
		};
	},
};
</script>

<style lang="scss" scoped></style>
