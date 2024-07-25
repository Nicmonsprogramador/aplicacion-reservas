import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import NewReservation from './components/NewReservation';
import ModifyReservation from './components/ModifyReservation';
import CancelReservation from './components/CancelReservation';
import ViewReservations from './components/ViewReservations';

const App = () => {
  return (
    <Router>
      <div>
        <nav>
          <ul>
            <li><Link to="/new">New Reservation</Link></li>
            <li><Link to="/reservations">View Reservations</Link></li>
          </ul>
        </nav>
        <Routes>
          <Route path="/new" element={<NewReservation />} />
          <Route path="/modify/:id" element={<ModifyReservation />} />
          <Route path="/cancel/:id" element={<CancelReservation />} />
          <Route path="/reservations" element={<ViewReservations />} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;
