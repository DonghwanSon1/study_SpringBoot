<template>
	<main>
		<div class="container py-4">
			<div class="row g-3">
				<div class="col col-4">
					<AppCard></AppCard>
					<!-- <app-card></app-card>도 됨 -->
				</div>
				<div class="col col-4">
					<AppCard></AppCard>
				</div>
				<div class="col col-4">
					<AppCard></AppCard>
				</div>
				<div class="col col-4">
					<AppCard></AppCard>
				</div>
				<div class="col col-4">
					<AppCard></AppCard>
				</div>
				<div class="col col-4">
					<AppCard></AppCard>
				</div>
			</div>
		</div>
	</main>
</template>

<script>
import AppCard from './AppCard.vue';
export default {
	template: {
		AppCard,
	},
	setup() {
		return {};
	},
	components: { AppCard },
};
</script>

<style lang="scss" scoped></style>
