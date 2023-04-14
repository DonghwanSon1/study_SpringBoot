<template>
	<main>
		<!-- <ProvideInject></ProvideInject> -->
		<LifecycleHooks></LifecycleHooks>
	</main>
</template>

<script>
import LifecycleHooks from './LifecycleHooks.vue';
import ProvideInject from './ProvideInject.vue';
export default {
	components: {
		ProvideInject,
		LifecycleHooks,
	},
	setup() {
		return {};
	},
};
</script>

<style lang="scss" scoped></style>
