// src/components/ModifyReservation.jsx
import React, { useState, useEffect } from 'react';
import axios from 'axios';

const ModifyReservation = ({ match }) => {
  const [formData, setFormData] = useState({
    name: '',
    date: '',
    service: ''
  });

  useEffect(() => {
    axios.get(`/api/reservations/${match.params.id}`)
      .then(response => setFormData(response.data))
      .catch(error => console.error('There was an error fetching the reservation!', error));
  }, [match.params.id]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.put(`/api/reservations/${match.params.id}`, formData)
      .then(response => alert('Reservation modified successfully!'))
      .catch(error => console.error('There was an error modifying the reservation!', error));
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Modify Reservation</h2>
      <label>
        Name:
        <input type="text" name="name" value={formData.name} onChange={handleChange} required />
      </label>
      <label>
        Date:
        <input type="date" name="date" value={formData.date} onChange={handleChange} required />
      </label>
      <label>
        Service:
        <input type="text" name="service" value={formData.service} onChange={handleChange} required />
      </label>
      <button type="submit">Modify Reservation</button>
    </form>
  );
};

export default ModifyReservation;
