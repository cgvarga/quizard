import React, { useState } from 'react';
import { Button, Container } from 'react-bootstrap';
import { useSelector, useDispatch } from 'react-redux';

const Quiz = () => {
	const { questions } = useSelector((state) => state.quizLoader.quiz);

	const [currentQuestion, setCurrentQuestion] = useState(0);
	const [showScore, setShowScore] = useState(false);
	const [score, setScore] = useState(0);

	const answerButtonHandler = (isCorrect) => {
		if (isCorrect === true) {
			setScore(score + 1);
		}
		const nextQuestion = currentQuestion + 1;
		if (nextQuestion < questions.length) {
			setCurrentQuestion(nextQuestion);
		} else {
			setShowScore(true);
		}
	};

	const resetQuizHandler = () => {
		setCurrentQuestion(0);
		setShowScore(false);
		setScore(0);
	};

	return (
		<Container>
			{showScore ? (
				<div className='score-section'>
					You scored {score} out of {questions.length}
					<div>
						<Button onClick={resetQuizHandler}>Retake Quiz</Button>
					</div>
				</div>
			) : (
				<>
					<div className='question-section'>
						<div className='question-count'>
							<span>Question {currentQuestion + 1}</span>/{questions.length}
						</div>
						<div className='question-text'>
							{questions[currentQuestion].value}
						</div>
					</div>
					<div className='answer-section'>
						{questions[currentQuestion].answers.map((answerOption) => (
							<Button onClick={() => answerButtonHandler(answerOption.correct)}>
								{answerOption.value}
							</Button>
						))}
					</div>
				</>
			)}
		</Container>
	);
};

export default Quiz;
