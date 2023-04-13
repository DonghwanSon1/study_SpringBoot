<template>
	<div class="card">
		<div class="card-body">
			<!-- type: news, notice -->
			<span class="badge bg-secondary">{{ typeName }}</span>
			<h5 class="card-title red mt-2">{{ title }}</h5>
			<p class="card-text">
				{{ contents }}
			</p>
			<a href="#" class="btn" :class="isLikeClass" @click="toggleLike">
				좋아요
			</a>
		</div>
	</div>
</template>

<script>
import { computed } from 'vue';

export default {
	// props: ['title', 'contents'], -> 기본 props의 선언 방식
	props: {
		type: {
			type: String,
			default: 'news',
			validator: value => {
				return ['news', 'notice'].includes(value);
			},
		},
		title: {
			type: String,
			required: true,
		},
		contents: {
			type: String,
			// required: true,
		},
		isLike: {
			type: Boolean,
			default: false,
		},
		obj: {
			type: Object,
			default: () => ({}),
		},
	},
	emits: ['toggleLike'],
	setup(props, context) {
		// console.log('props.title: ', props.title);
		const isLikeClass = computed(() =>
			props.isLike ? 'btn-danger' : 'btn-outline-danger',
		);
		const typeName = computed(() =>
			props.type === 'news' ? '뉴스' : '공지사항',
		);

		const toggleLike = () => {
			// props.isLike = !props.isLike; //자식에서 엄마의 값을 변경할 순 없다. 변경하고 싶을땐 아래의 방식으로는 가능하다.
			// props.obj.title = '김길동'; //JavaScript 언어 특징상 억지로 변경은 가능함.
			context.emit('toggleLike');
		};
		return {
			isLikeClass,
			typeName,
			toggleLike,
		};
	},
};
</script>

<style></style>
