$(document).ready(function () {
                $('.teacher-select').select2();
                $('.level-select').select2();
                $('.category-select').select2();
                $('#startDate').daterangepicker({
                    minDate: new Date(),
                    'locale': {
                        format: "DD/MM/YYYY",
                    }
                });
            });