<template>
	<div>
		<button @click="openModal">打开模态框</button>
		<div v-if="showModal" class="modal" @click="closeModal">
			<div class="modal-content" @click.stop>
				<span class="close" @click="closeModal">&times;</span>
				<p>这是一个模态对话框</p>
			</div>
		</div>
	</div>
</template>

<script>
export default {
	data() {
		return {
			showModal: false
		};
	},
	methods: {
		openModal() {
			this.showModal = true;
		},
		closeModal() {
			this.showModal = false;
		}
	}
}
</script>

<style scoped>
	.modal {
		display: block; 
		position: fixed;
		z-index: 1000;
		left: 0;
		top: 0;
		width: 100%;
		height: 100%;
		overflow: auto;
		background-color: rgba(0,0,0,0.4);
		padding-top: 60px;
	}
	.modal-content {
		background-color: #fefefe;
		margin: 5% auto;
		padding: 20px;
		border: 1px solid #888;
		width: 80%;
	}
	.close {
		color: #aaa;
		float: right;
		font-size: 28px;
		font-weight: bold;
		cursor: pointer;
	}
	.close:hover,
	.close:focus {
		color: black;
		text-decoration: none;
	}
</style>