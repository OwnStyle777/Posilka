import React, { useEffect, useState } from 'react';
import { ScrollView, StyleSheet, View } from 'react-native';
import { Avatar, Button, Card, Title, Paragraph, Text } from 'react-native-paper';
import { SvgUri } from 'react-native-svg';
import { Exercise } from '@/types/Exercise';
import { getExerciseById } from '@/app/api/ExerciseService'; 
import { useLocalSearchParams } from 'expo-router';

const ExerciseDetail = () => {
  const { exerciseId } = useLocalSearchParams();
  const [exercise, setExercise] = useState<Exercise | null>(null);

  useEffect(() => {
    const id = Number(exerciseId);
    if (isNaN(id)) {
      console.warn('Invalid exerciseId:', exerciseId); 
      return;
    }

    const fetchExerciseDetail = async () => {
      try {
        const response = await getExerciseById(id);
        setExercise(response.data);
      } catch (error) {
        console.error('Error fetching exercise details:', error);
      }
    };

    fetchExerciseDetail();
  }, [exerciseId]);

  if (!exercise) {
    return (
      <View style={styles.container}>
        <Text>Loading...</Text>
      </View>
    );
  }

  return (
    <ScrollView style={styles.container}>
      <Card style={styles.card}>
        <Card.Content>
          <View style={styles.imageContainer}>
            {exercise.mediaUrl?.endsWith('.svg') ? (
              <SvgUri width="100" height="100" uri={exercise.mediaUrl} />
            ) : (
              <SvgUri width="100" height="100" uri="https://www.svgrepo.com/download/382003/exercise-health-fitness-weight.svg"/>
            )}
          </View>
          <Title style={styles.title}>{exercise.name}</Title>
          <Paragraph style={styles.subTitle}>Muscle Group: {exercise.muscleGroup}</Paragraph>
          <Paragraph style={styles.text}>Difficulty: {exercise.difficulty}</Paragraph>
          <Paragraph style={styles.text}>Instructions: {exercise.instructions}</Paragraph>
        </Card.Content>
        <Card.Actions>
          <Button style={styles.button} labelStyle={styles.buttonText} onPress={() => console.log('Edit')}>
            Edit
          </Button>
        </Card.Actions>
      </Card>
    </ScrollView>
  );
};

const styles = StyleSheet.create({
  button:{
    backgroundColor: '#D1F5FF',
  },
  buttonText:{
    color: '#333'
  },
  container: {
    flex: 1,
    padding: 10,
    backgroundColor: '#f4f4f4',
  },
  card: {
    marginBottom: 20,
    borderRadius: 12,
    elevation: 5,
    backgroundColor: '#ffffff',
  },
  imageContainer: {
    alignItems: 'center',
    marginBottom: 15,
  },
  title: {
    fontSize: 24,
    fontWeight: 'bold',
    color: '#333',
  },
  subTitle: {
    fontSize: 18,
    marginBottom: 10,
    color: '#888',
  },
  text: {
    fontSize: 16,
    marginBottom: 10,
    color: '#333',
  },
});

export default ExerciseDetail;