<template>
	<div>
		<!-- @click="$emit('createPost', 1, 2, 3, '손동환')"  // emit을 사용하므로서 자식컴포넌트에서 부모 컴포넌트로 이벤트를 발생 시키게 할 수 있다.  -->
		<input v-model="title" type="text" class="form-control" />

		<button class="btn btn-primary" @click="createPost">button</button>
	</div>
</template>

<script>
import { ref } from 'vue';

export default {
	//emits: ['createPost'], // 자식 컴포넌트에서도 이벤트 작동 시키게 하고 싶으면 이렇게 선언하면 된다.

	emits: {
		createPost: newTitle => {
			console.log('vaildator: ', newTitle);
			if (!newTitle) {
				return false;
			}
			return true;
		},
	}, // 객체 방식으로 선언하기
	setup(props, { emit }) {
		const title = ref('');
		const createPost = () => {
			emit('createPost', title.value);
		};
		return { createPost, title };
	},
};
</script>

<style lang="scss" scoped></style>
