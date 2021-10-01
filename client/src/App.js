import React from 'react';
import './bootstrap.min.css';
import { Form, Button, Container } from 'react-bootstrap';
import Footer from './components/Footer';
import Header from './components/Header';

const App = () => {
	return (
		<>
			<Header />
			<Container>
				{/* TODO refactor login page */}
				<h1>Login</h1>
				<Form>
					<Form.Group controlId='email'>
						<Form.Label>Email Address</Form.Label>
						<Form.Control type='email' placeholder='Enter email'></Form.Control>
					</Form.Group>

					<Form.Group controlId='password'>
						<Form.Label>Password</Form.Label>
						<Form.Control
							type='password'
							placeholder='Enter password'
						></Form.Control>
					</Form.Group>

					<Button type='submit' variant='primary'>
						Sign In
					</Button>
				</Form>
			</Container>

			<Footer />
		</>
	);
};

export default App;
