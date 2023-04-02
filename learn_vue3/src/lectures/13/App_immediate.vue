<template>
	<div>
		<p>{{ message }}</p>
		<p>{{ reversMessage }}</p>
	</div>
</template>

<script>
import { ref, watch } from 'vue';

export default {
	setup() {
		const message = ref('Hello Vue3');
		const reversMessage = ref('');

		const reverseFunction = () => {
			console.log('즉시 실행함!!');
			reversMessage.value = message.value.split('').reverse().join('');
		};
		watch(message, reverseFunction);
		reverseFunction();

		return {
			message,
			reversMessage,
		};
	},
};
</script>

<style lang="scss" scoped></style>
