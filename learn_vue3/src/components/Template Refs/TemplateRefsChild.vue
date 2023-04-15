<template>
	<div>
		{{ $parent }}
		<ul>
			<li v-for="furit in $parent.fruits" :key="furit">{{ furit }}</li>
		</ul>
	</div>
</template>

<script>
import { ref } from 'vue';
export default {
	setup() {
		const message = ref('Hello ~~~~');
		const sayHello = () => {
			alert(message.value);
		};

		return {
			message,
			sayHello,
		};
	},
};
</script>

<style lang="scss" scoped></style>
