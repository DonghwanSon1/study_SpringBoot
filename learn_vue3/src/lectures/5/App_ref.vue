<template>
	<div>
		<p>{{ message }}</p>
		<button v-on:click="addMessage">add Click</button>
	</div>
</template>

<script>
import { ref } from 'vue';

export default {
	setup() {
		// let message = reactive('Hello Vue3');
		// 위에처럼 할 시 반응형이 안된다. -> reactive는 반응형 함수인데 반응형 함수는 객체로 선언을 해줘야 가능하다.
		// 즉 위에처럼 말고, reactive({ value: 'Hello Vue3' }) 이렇게 해야된다.
		// 따라서, addMessage도 message.value += '!'; 을 써주면 된다.
		// 하지만 이런 단점을 보안하기 위해 ref()함수가 있다.
		let message = ref('Hello Vue3!');
		const addMessage = () => {
			message.value += '!';
		};
		console.log(message);
		console.log('message: ', message.value);
		console.log('message typeof: ', typeof message.value);
		return {
			message,
			addMessage,
		};
	},
};
</script>

<style lang="scss" scoped></style>
