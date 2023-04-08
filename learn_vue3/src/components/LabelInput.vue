<template>
	<label>
		{{ label }}
		<!-- v-model="username" -->
		<input
			:value="modelValue"
			@input="event => $emit('update:modelValue', event.target.value)"
			type="text"
		/>
	</label>
</template>

<script>
export default {
	props: ['modelValue', 'label'], // vue2에서는 value였고,
	emits: ['update:modelValue'], // @input이였다.
	setup() {
		return {};
	},
};
</script>

<style lang="scss" scoped></style>
