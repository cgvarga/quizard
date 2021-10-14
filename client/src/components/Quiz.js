import React from 'react';
import axios from 'axios';
import QuizService from '../services/QuizService';

export default class Quiz extends React.Component {
	constructor() {
		super();

		this.state = {
			title: '',
			questions: [],
		};
	}

	componentDidMount() {
		// error here with 'then'
		QuizService.getQuizes().then((res) => {
			console.log(res);
		});
	}

	render() {
		return <div>QUIZ</div>;
	}
}
