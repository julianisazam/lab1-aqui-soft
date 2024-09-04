import React, { useState } from 'react';
import axios from 'axios';
import './FlightSearchForm.css';  

function FlightSearchForm() {
    const [flights, setFlights] = useState([]);
    const [filters, setFilters] = useState({
        
        startDate: '',
        endDate: '',
        origin: '',
        destination: '',
        maxPrice: '',
        category: '',
        baggage: ''
    });

    const handleChange = (e) => {
        setFilters({
            ...filters,
            [e.target.name]: e.target.value
        });
    };

    const handleSearch = () => {
        axios.get('http://localhost:3000/api/sitas', {
            params: {
                startDate: filters.startDate,
                endDate: filters.endDate,
                origin: filters.origin,
                destination: filters.destination,
                maxPrice: filters.maxPrice,
                baggage: filters.baggage,
                category: filters.category
            }
        })
        .then(response => {
            setFlights(response.data);
        })
        .catch(error => {
            console.error('Error fetching flights:', error);
        });
    };

    return (
        <div className="container">
            <h1>Flight Search</h1>
            <form>
                <div>
                    <label>Start Date:</label>
                    <input type="date" name="startDate" value={filters.startDate} onChange={handleChange} />
                </div>
                <div>
                    <label>End Date:</label>
                    <input type="date" name="endDate" value={filters.endDate} onChange={handleChange} />
                </div>
                <div>
                    <label>Origin:</label>
                    <input type="text" name="origin" placeholder="Type the origin" value={filters.origin} onChange={handleChange} />
                </div>
                <div>
                    <label>Destination:</label>
                    <input type="text" name="destination" placeholder="Type the Destination" value={filters.destination} onChange={handleChange} />
                </div>
                <div>
                    <label>Max Price:</label>
                    <input type="number" name="maxPrice" placeholder="Enter the flight price" value={filters.maxPrice} onChange={handleChange} />
                </div>
                <div>
                <label>Baggage Type:</label>
                <select name="baggage" value={filters.baggage} onChange={handleChange}>
                    <option value="">Select baggage type</option>
                    <option value="Carry-on">Carry-on</option>
                    <option value="Checked">Checked</option>
                </select>
            </div>

            <div>
                <label>Travel Class:</label>
                <select name="travelClass" value={filters.category} onChange={handleChange}>
                    <option value="">Select travel class</option>
                    <option value="Business">Business</option>
                    <option value="Tourist">Economy</option>
                </select>
            </div>
                        <button type="button" onClick={handleSearch}>Search Flights</button>
            </form>

            <h2>Available Flights</h2>
            <table>
                <thead>
                    <tr>
                        <th>Origin</th>
                        <th>Destination</th>
                        <th>Date</th>
                        <th>Price</th>
                        <th>Baggage Type</th>
                        <th>Travel Class</th>
                    </tr>
                </thead>
                <tbody>
                    {flights.length > 0 ? flights.map(flight => (
                        <tr key={flight.id}>
                            <td>{flight.origin}</td>
                            <td>{flight.destination}</td>
                            <td>{flight.date}</td>
                            <td>{flight.price}</td>
                            <td>{flight.baggage}</td>
                            <td>{flight.category}</td>
                        </tr>
                    )) : (
                        <tr>
                            <td colSpan="6">No flights available for the selected filters.</td>
                        </tr>
                    )}
                </tbody>
            </table>
        </div>
    );
}

export default FlightSearchForm;
