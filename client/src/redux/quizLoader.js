import { createSlice } from '@reduxjs/toolkit';

const quizFromStorage = localStorage.getItem('quiz')
	? JSON.parse(localStorage.getItem('quiz'))
	: {};

const initialState = {
	quiz: quizFromStorage,
};

export const quizLoaderSlice = createSlice({
	name: 'quizLoader',
	initialState,
	reducers: {
		load: (state, action) => {
			state.quiz = action.payload;

			localStorage.setItem('quiz', JSON.stringify(state.quiz));
		},
		reset: (state) => {
			state.quiz = {};
		},
	},
});

// Action creators are generated for each case reducer function
export const { load, reset } = quizLoaderSlice.actions;

export default quizLoaderSlice.reducer;
