import React from 'react';
import { Container } from 'react-bootstrap';
import QuizService from '../services/QuizService';

export default class Quiz extends React.Component {
	constructor() {
		super();

		this.state = {
			quizes: [],
		};
	}

	componentDidMount() {
		QuizService.getQuizes().then((res) => {
			this.setState({ quizes: res.data });
		});
	}

	//TODO refactor this into Quiz List and Quiz component
	//link to quiz page with questions and radio button
	render() {
		return (
			<>
				<Container>
					<h1>Quizes</h1>
					{this.state.quizes.map((quiz) => (
						<ul>
							<li>Title: {quiz.title}</li>
							{quiz.questions.map((question) => (
								<ol>{question.value}</ol>
							))}
						</ul>
					))}
				</Container>
			</>
		);
	}
}
