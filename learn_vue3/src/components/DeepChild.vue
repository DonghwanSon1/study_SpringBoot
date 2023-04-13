<template>
	<div class="card">
		<div class="card-header">Deep Child Component</div>
		<div class="card-body">
			<p>staticMessage: {{ staticMessage }}</p>
			<p>Message: {{ message }}</p>
			<p>count: {{ count }}</p>
		</div>
	</div>
</template>

<script>
import { inject } from 'vue';

export default {
	setup() {
		const staticMessage = inject('static-message', 'default message');
		const { message, updateMessage } = inject('Message');
		updateMessage('!!!!!');
		// message.value = message.value + '!'; // readonly 속성을 줬기 때문에 추가로 변경이 가능하지 않는다.
		const count = inject('count');
		return {
			staticMessage,
			message,
			count,
		};
	},
};
</script>

<style lang="scss" scoped></style>
