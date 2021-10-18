import React from 'react';
import { Navbar, Container, Nav } from 'react-bootstrap';
import { LinkContainer } from 'react-router-bootstrap';

const Header = () => {
	return (
		<>
			<Navbar bg='dark' variant='dark'>
				<Container>
					<LinkContainer to='/'>
						<Navbar.Brand>Quizard</Navbar.Brand>
					</LinkContainer>

					<Nav className='me-auto'>
						<LinkContainer to='/'>
							<Nav.Link>Home</Nav.Link>
						</LinkContainer>
						<LinkContainer to='/quizzes'>
							<Nav.Link>Quizzes</Nav.Link>
						</LinkContainer>
					</Nav>
				</Container>
			</Navbar>
		</>
	);
};

export default Header;
