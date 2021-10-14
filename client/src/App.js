import React from 'react';
import './bootstrap.min.css';
import Footer from './components/Footer';
import Header from './components/Header';
import LoginScreen from './screens/LoginScreen';
import Quiz from './components/Quiz';

const App = () => {
	return (
		<>
			<Header />
			<LoginScreen />
			<Quiz />
			<Footer />
		</>
	);
};

export default App;
