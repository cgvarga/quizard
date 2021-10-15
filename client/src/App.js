import React from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import './bootstrap.min.css';
import Footer from './components/Footer';
import Header from './components/Header';
import LoginScreen from './screens/LoginScreen';
import QuizList from './components/QuizList';
import Quiz from './components/Quiz';

const App = () => {
	return (
		<Router>
			<Header />
			<main className='py-3'>
				<Route path='/quiz/:title' component={Quiz} />
				<Route path='/quizzes' component={QuizList} />
				<Route path='/' component={LoginScreen} exact />
			</main>
			<Footer />
		</Router>
	);
};

export default App;
