<template>
	<div class="p-3 bg-danger">
		<button class="btn btn-primary" type="button" v-bind="$attrs">
			<!-- v-bind="$attrs" -->
			My Button{{ message }}
		</button>
		<!-- {{ $attrs }}를 사용하여 속성을 원하는 곳에 상속 시킬 수 있다. -->
	</div>
</template>

<script>
export default {
	inheritAttrs: false, // root 속성 상속을 거절한다.
};
</script>

<script setup>
import { ref } from 'vue';
const message = ref('message');
</script>

<style lang="scss" scoped></style>
