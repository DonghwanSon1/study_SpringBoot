<template>
	<div>
		{{ $parent }}
		<ul>
			<li v-for="furit in $parent.fruits" :key="furit">{{ furit }}</li>
		</ul>
	</div>
</template>

<script setup>
import { ref } from 'vue';

const message = ref('Hello ~~~~');
const sayHello = () => {
	alert(message.value);
};
defineExpose({
	message: message,
	sayHello,
});
</script>

<style lang="scss" scoped></style>
