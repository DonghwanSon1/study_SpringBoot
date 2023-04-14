<template>
	<div class="container py-4">
		<input ref="inputRef" type="text" value="Hello world!" />
		<hr />
		<button @click="visible = !visible">Toggle Child</button>
		<LifecycleChild v-if="visible"></LifecycleChild>
		<p id="message">{{ message }}</p>
	</div>
</template>

<script>
import { onBeforeMount, onBeforeUpdate, onMounted, onUpdated, ref } from 'vue';
import LifecycleChild from './LifecycleChild.vue';
export default {
	components: {
		LifecycleChild,
	},
	setup() {
		// 	console.log('setup');
		const inputRef = ref(null);
		const message = ref('');
		const visible = ref(false);
		// 	onBeforeMount(() => {
		// 		console.log('onBeforeMount', inputRef.value);
		// 	});
		// 	onMounted(() => {
		// 		console.log('onMounted', inputRef.value.value);
		// 	});
		// },
		// 위에껄 보면 부모 컴포넌트 먼저 실행되고 beforemount 실행 후 자식 컴포넌트에서 셋업 비포마운트 마운티드 까지 생성 되면 후에 부모에서 마운티드가 실행된다.

		// onBeforeUpdate(() => {
		// 	console.log('onBeforeUpdate', message.value);
		// 	console.log(
		// 		'DOM Content: ',
		// 		document.querySelector('#message').textContent,
		// 	);
		// });
		// onUpdated(() => {
		// 	console.log('onUpdated', message.value);
		// 	console.log(
		// 		'DOM Content: ',
		// 		document.querySelector('#message').textContent,
		// 	);
		// });
		return {
			inputRef,
			message,
			visible,
		};

		// data: () => ({
		// 	dataMassage: 'data message',
		// }),
		// beforeCreate() {
		// 	console.log('beforeCreate', this.dataMassage);
		// },
		// created() {
		// 	console.log('created', this.dataMassage);
		// 	console.log(this);
		// }, //Vue2 에서는 이렇게 사용함!
	},
};
</script>

<style lang="scss" scoped></style>
