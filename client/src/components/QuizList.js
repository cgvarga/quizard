import React, { useState, useEffect } from 'react';
import { Container, Card, Button } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import { useSelector, useDispatch } from 'react-redux';
import { load, reset } from '../redux/quizLoader';
import QuizService from '../services/QuizService';

const QuizList = () => {
	const [quizes, setQuizes] = useState([]);
	const dispatch = useDispatch();

	useEffect(() => {
		QuizService.getQuizes().then((res) => {
			setQuizes(res.data);
		});
	}, [dispatch]);

	const takeQuizHandler = (quiz) => {
		dispatch(load(quiz));
	};

	return (
		<>
			<Container>
				<h1>Quizes</h1>
				{quizes.map((quiz) => (
					<Card key={quiz.title}>
						<Card.Body>
							<Card.Title>{quiz.title}</Card.Title>
							<Link to={`/quiz/${quiz.title}`}>
								<Button variant='primary' onClick={() => takeQuizHandler(quiz)}>
									Take Quiz
								</Button>
							</Link>
						</Card.Body>
					</Card>
				))}
			</Container>
		</>
	);
};

export default QuizList;
