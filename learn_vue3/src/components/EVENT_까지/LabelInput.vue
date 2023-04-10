<template>
	<label class="child-class" style="border: 1px solid black" id="child-id">
		{{ label }}
		<!-- v-model="username" -->
		<input v-model="value" type="text" />
		<!-- :value="modelValue"
		@input="event => $emit('update:modelValue', event.target.value)" -->
	</label>
</template>

<script>
import { computed } from 'vue';

export default {
	props: ['modelValue', 'label'], // vue2에서는 value였고,
	emits: ['update:modelValue'], // @input이였다.
	setup(props, { emit }) {
		const value = computed({
			get() {
				return props.modelValue;
			},
			set(value) {
				emit('update:modelValue', value);
			},
		});
		return { value };
	},
};
</script>

<style lang="scss" scoped></style>
