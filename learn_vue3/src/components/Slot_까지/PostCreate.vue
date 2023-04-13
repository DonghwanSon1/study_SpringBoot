<template>
	<div class="row g-3">
		<!-- @click="$emit('createPost', 1, 2, 3, '손동환')"  // emit을 사용하므로서 자식컴포넌트에서 부모 컴포넌트로 이벤트를 발생 시키게 할 수 있다.  -->
		<div class="col col-2">
			<select
				v-model="type"
				class="form-select"
				aria-label="Default select example"
			>
				<option value="news">뉴스</option>
				<option value="notice">공지사항</option>
			</select>
		</div>
		<div class="col col-8">
			<input v-model="title" type="text" class="form-control" />
		</div>
		<div class="col col-2 d-grid">
			<button class="btn btn-primary" @click="createPost">추가</button>
		</div>
	</div>
</template>

<script>
import { ref } from 'vue';

export default {
	//emits: ['createPost'], // 자식 컴포넌트에서도 이벤트 작동 시키게 하고 싶으면 이렇게 선언하면 된다.

	emits: {
		createPost: newPost => {
			if (!newPost.type) {
				return false;
			} else if (!newPost.title) {
				return false;
			}
			return true;
		},
	}, // 객체 방식으로 선언하기
	setup(props, { emit }) {
		const type = ref('news');
		const title = ref('');
		const createPost = () => {
			const newPost = {
				type: type.value,
				title: title.value,
			};
			emit('createPost', newPost);
			type.value = 'news';
			title.value = '';
		};
		return { type, createPost, title };
	},
};
</script>

<style lang="scss" scoped></style>
