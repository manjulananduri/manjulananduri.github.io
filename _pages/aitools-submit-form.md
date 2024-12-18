---
layout: default-aitools
title: TipSeason AI Tool directory - Submit tool
permalink: /ai-tools/submit-form
---

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Submit AI Tool - TipSeason</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .form-container {
            max-width: 800px;
            margin: 2rem auto;
            padding: 2rem;
            background: #ffffff;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0,0,0,0.1);
        }
        
        .header {
            text-align: center;
            margin-bottom: 2rem;
        }
        
        .header h1 {
            color: #2c3e50;
            font-size: 2rem;
            margin-bottom: 1rem;
        }
        
        .form-label {
            font-weight: 600;
            color: #34495e;
        }
        
        .required::after {
            content: "*";
            color: #e74c3c;
            margin-left: 4px;
        }
        
        .form-control:focus {
            border-color: #3498db;
            box-shadow: 0 0 0 0.2rem rgba(52,152,219,0.25);
        }
        
        .btn-submit {
            background-color: #2ecc71;
            border: none;
            padding: 10px 30px;
            font-weight: 600;
            transition: all 0.3s ease;
        }
        
        .btn-submit:hover {
            background-color: #27ae60;
            transform: translateY(-2px);
        }
        
        .error-message {
            color: #e74c3c;
            font-size: 0.875rem;
            margin-top: 0.25rem;
            display: none;
        }
        
        .success-message {
            display: none;
            background-color: #2ecc71;
            color: white;
            padding: 1rem;
            border-radius: 5px;
            margin-bottom: 1rem;
        }
    </style>
</head>
<body class="bg-light">
    <div class="container">
        <div class="form-container">
            <div class="header">
                <h1>Submit AI Tool</h1>
                <p class="text-muted">Join TipSeason AI Tools Directory</p>
            </div>
            
            <div class="success-message">
                Thank you! Your AI tool has been submitted successfully.
            </div>
            
            <form id="aiToolForm">
                <div class="mb-3">
                    <label for="email" class="form-label required">Email</label>
                    <input type="email" class="form-control" id="email" required>
                    <div class="error-message" id="emailError">Please enter a valid email address</div>
                </div>
                
                <div class="mb-3">
                    <label for="toolName" class="form-label required">Tool Name</label>
                    <input type="text" class="form-control" id="toolName" required>
                    <div class="error-message" id="toolNameError">Tool name is required</div>
                </div>
                
                <div class="mb-3">
                    <label for="toolUrl" class="form-label required">Tool URL</label>
                    <input type="url" class="form-control" id="toolUrl" required>
                    <div class="error-message" id="toolUrlError">Please enter a valid URL</div>
                </div>
                
                <div class="mb-3">
                    <label for="shortDescription" class="form-label required">Short Description (10-30 words)</label>
                    <textarea class="form-control" id="shortDescription" rows="2" required></textarea>
                    <div class="error-message" id="shortDescError">Description must be between 10 and 30 words</div>
                </div>
                
                <div class="mb-3">
                    <label for="longDescription" class="form-label required">Long Description (50-500 words)</label>
                    <textarea class="form-control" id="longDescription" rows="4" required></textarea>
                    <div class="error-message" id="longDescError">Description must be between 50 and 500 words</div>
                </div>
                
                <div class="mb-3">
                    <label class="form-label required">Are you interested in Advertising?</label>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="advertising" id="adYes" value="yes" required>
                        <label class="form-check-label" for="adYes">Yes</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="advertising" id="adNo" value="no" required>
                        <label class="form-check-label" for="adNo">No</label>
                    </div>
                </div>
                
                <div class="mb-3">
                    <label for="sponsorship" class="form-label required">Sponsorship Details</label>
                    <textarea class="form-control" id="sponsorship" rows="3" required></textarea>
                    <div class="error-message" id="sponsorshipError">Please provide sponsorship details or enter NA</div>
                </div>
                
                <div class="mb-3">
                    <label for="source" class="form-label">How did you hear about us?</label>
                    <input type="text" class="form-control" id="source">
                </div>
                
                <div class="mb-3">
                    <label for="socialMedia" class="form-label">Social Media URLs</label>
                    <textarea class="form-control" id="socialMedia" rows="2"></textarea>
                </div>
                
                <div class="text-center mt-4">
                    <button type="submit" class="btn btn-submit btn-lg">Submit Tool</button>
                </div>
            </form>
        </div>
    </div>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.2/js/bootstrap.bundle.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#aiToolForm').on('submit', function(e) {
                e.preventDefault();

                // Reset error messages
                $('.error-message').hide();
                let hasErrors = false;

                // Validate email
                const email = $('#email').val();
                if (!isValidEmail(email)) {
                    $('#emailError').show();
                    hasErrors = true;
                }

                // Validate tool name
                if (!$('#toolName').val().trim()) {
                    $('#toolNameError').show();
                    hasErrors = true;
                }

                // Validate URL
                const url = $('#toolUrl').val();
                if (!isValidUrl(url)) {
                    $('#toolUrlError').show();
                    hasErrors = true;
                }

                // Validate short description
                const shortDescWords = countWords($('#shortDescription').val());
                if (shortDescWords < 10 || shortDescWords > 30) {
                    $('#shortDescError').show();
                    hasErrors = true;
                }

                // Validate long description
                const longDescWords = countWords($('#longDescription').val());
                if (longDescWords < 50 || longDescWords > 500) {
                    $('#longDescError').show();
                    hasErrors = true;
                }

                // Validate sponsorship
                const sponsorship = $('#sponsorship').val().trim();
                if (!sponsorship || (sponsorship.toLowerCase() !== 'na' && sponsorship.length < 10)) {
                    $('#sponsorshipError').show();
                    hasErrors = true;
                }

                if (!hasErrors) {
                    // Collect form data
                    const formData = {
                        email: email,
                        toolName: $('#toolName').val(),
                        toolUrl: url,
                        shortDescription: $('#shortDescription').val(),
                        longDescription: $('#longDescription').val(),
                        advertising: $('input[name="advertising"]:checked').val(),
                        sponsorship: sponsorship,
                        source: $('#source').val(),
                        socialMedia: $('#socialMedia').val()
                    };

                    // Submit to backend (replace with your actual endpoint)
                    submitForm(formData);
                }
            });

            function isValidEmail(email) {
                return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
            }

            function isValidUrl(url) {
                try {
                    new URL(url);
                    return true;
                } catch {
                    return false;
                }
            }

            function countWords(str) {
                return str.trim().split(/\s+/).length;
            }

            function submitForm(formData) {
                // Replace this with your actual backend endpoint
                const backendUrl = 'https://your-backend-endpoint.com/submit';

                $.ajax({
                    url: backendUrl,
                    method: 'POST',
                    data: JSON.stringify(formData),
                    contentType: 'application/json',
                    success: function(response) {
                        $('.success-message').show();
                        $('#aiToolForm')[0].reset();
                        setTimeout(() => {
                            $('.success-message').fadeOut();
                        }, 5000);
                    },
                    error: function(xhr, status, error) {
                        alert('There was an error submitting the form. Please try again later.');
                    }
                });
            }
        });
    </script>
