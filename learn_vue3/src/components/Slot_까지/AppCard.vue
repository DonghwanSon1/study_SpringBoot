<template>
	<div class="card">
		<div v-if="$slots.header" class="card-header">
			<slot name="header" header-message="헤더 메시지"></slot>
		</div>
		<!-- {{ $slots }} -->
		<div v-if="$slots.default" class="card-body">
			<slot :child-message="childMessage" hello-message="안녕하신가요?!"></slot>
		</div>
		<div v-if="hasFooter" class="card-footer text-body-secondary">
			<slot name="footer" footer-message="푸터 메시지"></slot>
		</div>
	</div>
</template>

<script>
import { ref, computed } from 'vue';

export default {
	setup(props, { slots }) {
		const childMessage = ref(
			'하위(자식) 컴포넌트의 데이터는 상위에서 사용할 수 없습니다!',
		);
		const hasFooter = computed(() => !!slots.footer);
		return {
			childMessage,
			hasFooter,
		};
	},
};
</script>

<style lang="scss" scoped></style>
