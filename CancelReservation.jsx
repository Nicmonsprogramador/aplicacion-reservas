import React from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const CancelReservation = ({ match }) => {
  const navigate = useNavigate();

  const handleCancel = () => {
    axios.delete(`/api/reservations/${match.params.id}`)
      .then(response => {
        alert('Reservation cancelled successfully!');
        navigate('/reservations');
      })
      .catch(error => console.error('There was an error cancelling the reservation!', error));
  };

  return (
    <div>
      <h2>Cancel Reservation</h2>
      <button onClick={handleCancel}>Cancel Reservation</button>
    </div>
  );
};

export default CancelReservation;
