import React from 'react';
import { Container, Card, Button } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import QuizService from '../services/QuizService';

export default class QuizList extends React.Component {
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

	render() {
		return (
			<>
				<Container>
					<h1>Quizes</h1>
					{this.state.quizes.map((quiz) => (
						<Card key={quiz.title}>
							<Card.Body>
								<Card.Title>{quiz.title}</Card.Title>
								<Link to={`/quiz/${quiz.title}`}>
									<Button variant='primary'>Take Quiz</Button>
								</Link>
							</Card.Body>
						</Card>
					))}
				</Container>
			</>
		);
	}
}
