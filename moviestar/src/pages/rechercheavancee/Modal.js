import React from 'react';

const Modal = ({ title, results, onClose }) => {
    return (
        <div className="modal-overlay">
            <div className="modal">
                <div className="modal-header">
                    <h2>{title}</h2>
                    <button onClick={onClose}>&times;</button>
                </div>
                <div className="modal-content">
                    {results && results.length > 0 ? (
                        <ul>
                            {results.map((result, index) => (
                                <li key={index}>{result}</li>
                            ))}
                        </ul>
                    ) : (
                        <p>No results to display</p>
                    )}
                </div>
            </div>
        </div>
    );
};

export default Modal;
