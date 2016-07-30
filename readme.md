# SAFI Fiesta Events EMS

## Official Documentation

### Project Setup

Open terminal in the directory and run `composer install`

If you run into the following error
`[ErrorException]
file_put_contents(C:\Users\julian\www\ems.v1\bootstrap/cache/services.php):
failed to open stream: No such file or directory`

add the folder then run the command again.

Once complete run `npm install` to install all the front end dependencies
then run `gulp` to compile all the scrips and stylesheets


Copy the .env.example file to .env
Now change the settings for the database and url to match those set up on your machine

To initiate the database run `php artisan migrate` followed by `php artisan db:seed`